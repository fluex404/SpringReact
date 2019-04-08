package com.fluex404.reactspring.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Data
public class ProjectTask {
    @Id
    private UUID id;
    @NotBlank(message = "Summary can't blank :D")
    private String summary;
    private String acceptanceCriteria;
    private String status;

    public ProjectTask() {
        this.id = UUID.randomUUID();
    }
    public ProjectTask(UUID id, String summary, String acceptanceCriteria, String status) {
        this.id = id;
        this.summary = summary;
        this.acceptanceCriteria = acceptanceCriteria;
        this.status = status;
    }
    public ProjectTask(String summary, String acceptanceCriteria, String status) {
        this();
        this.summary = summary;
        this.acceptanceCriteria = acceptanceCriteria;
        this.status = status;
    }
}
