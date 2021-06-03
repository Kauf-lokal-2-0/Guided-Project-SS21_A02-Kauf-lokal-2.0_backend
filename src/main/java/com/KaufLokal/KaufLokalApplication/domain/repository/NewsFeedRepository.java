package com.KaufLokal.KaufLokalApplication.domain.repository;

import com.KaufLokal.KaufLokalApplication.domain.model.Newsfeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NewsFeedRepository extends JpaRepository<Newsfeed, UUID> {
}
