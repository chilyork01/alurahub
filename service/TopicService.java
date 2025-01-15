package com.forohub.alura.service;

import com.forohub.alura.model.Topic;
import com.forohub.alura.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indica que esta clase es un servicio de Spring
public class TopicService {

    private final TopicRepository topicRepository;

    // Constructor para inyectar el repositorio
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    // Método para obtener todos los tópicos
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    // Método para obtener un tópico por ID
    public Optional<Topic> getTopicById(Long id) {
        return topicRepository.findById(id);
    }

    // Método para crear un nuevo tópico
    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    // Método para actualizar un tópico existente
    public Topic updateTopic(Long id, Topic updatedTopic) {
        return topicRepository.findById(id).map(existingTopic -> {
            existingTopic.setTitle(updatedTopic.getTitle());
            existingTopic.setMessage(updatedTopic.getMessage());
            existingTopic.setStatus(updatedTopic.getStatus());
            return topicRepository.save(existingTopic);
        }).orElseThrow(() -> new IllegalArgumentException("Topic not found with id: " + id));
    }

    // Método para eliminar un tópico por ID
    public void deleteTopic(Long id) {
        if (topicRepository.existsById(id)) {
            topicRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Topic not found with id: " + id);
        }
    }
}
