/*
 * JBoss, Home of Professional Open Source
 * Copyright 2016, Red Hat, Inc., and individual contributors
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.swarmic.examples.jparest;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ken Finnigan
 */
@ApplicationScoped
public class EmployeeService {

    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;

    final static Logger LOG = Logger.getLogger(EmployeeService.class);


    public List<Employee> getAll() {
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }


    public List<Employee> getSlow() {
        List<Employee> emp = new ArrayList<>();

        for (int i = 1; i < 9; i++) {
            emp.add(em.find(Employee.class,i));
            LOG.info("Read emp # " +i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException((e));
            }
        }
        return emp;

    }

    public void rem() {
        remTimer(0);
    }

    public void remSlow() {
        remTimer(1000);
    }


    public void remTimer(long millis) {

        for (int i = 1; i < 9; i++) {
            em.remove(em.find(Employee.class,i));
            LOG.info("Removed emp # " +i);
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException((e));
            }
        }

    }
}
