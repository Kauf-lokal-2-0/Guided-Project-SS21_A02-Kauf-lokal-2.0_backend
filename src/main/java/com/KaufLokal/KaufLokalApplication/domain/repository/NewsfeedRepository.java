package com.KaufLokal.KaufLokalApplication.domain.repository;

import com.KaufLokal.KaufLokalApplication.domain.model.Newsfeed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NewsfeedRepository extends JpaRepository<Newsfeed, UUID> {

}
