package com.scolerad.spring.client.communication;

import com.scolerad.spring.client.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/Rest_Server_war_exploded/api/employees";
    public List<Employee> getAllEmployees() {
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {});

        return responseEntity.getBody();
    }

    public Employee getEmployeeById(int id) {
        ResponseEntity<Employee> responseEntity =
                restTemplate.exchange(URL + "/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<Employee>() {});

        return responseEntity.getBody();
    }

    public void saveEmployee(Employee employee) {

        if (employee.getId() == 0) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New employee was added to DB");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with ID " + employee.getId() + " was updated");
        }
    }

    public void deletemployee(int id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with " + id + " was deleted");
    }
}
