package com.KaufLokal.KaufLokalApplication.domain.repository;

import com.KaufLokal.KaufLokalApplication.domain.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}
