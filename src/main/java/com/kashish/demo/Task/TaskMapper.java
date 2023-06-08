package com.kashish.demo.Task;


import com.kashish.demo.Task.dtos.ResponseBodyDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class TaskMapper {
    public List<ResponseBodyDTO> mapTasksToResponseBodyDTOs(List<Task> tasks) {
        List<ResponseBodyDTO> response = new ArrayList<>();
        for (Task task : tasks) {
            ResponseBodyDTO responseBodyDTO = new ResponseBodyDTO(
                    task.getName(),
                    task.getDuedate(),
                    task.getCompleted()
            );
            response.add(responseBodyDTO);
        }
        return response;
    }
}
