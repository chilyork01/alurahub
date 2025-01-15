package com.forohub.alura.repository;

import com.forohub.alura.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

// El repositorio para la entidad Topic
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
