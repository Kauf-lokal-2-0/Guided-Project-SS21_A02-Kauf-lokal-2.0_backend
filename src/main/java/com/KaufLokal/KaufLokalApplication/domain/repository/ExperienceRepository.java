package com.KaufLokal.KaufLokalApplication.domain.repository;

import com.KaufLokal.KaufLokalApplication.domain.model.Experience;
import com.KaufLokal.KaufLokalApplication.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface ExperienceRepository extends JpaRepository<Experience, UUID> {
    public Set<Experience> findAllExperienceByUser(User user);
}
