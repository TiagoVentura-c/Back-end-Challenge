package com.example.challenge.repository;

import com.example.challenge.models.Launch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaunchRepository extends JpaRepository<Launch, String> {

}
