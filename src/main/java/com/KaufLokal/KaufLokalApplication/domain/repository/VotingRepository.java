package com.KaufLokal.KaufLokalApplication.domain.repository;

import com.KaufLokal.KaufLokalApplication.domain.model.Vendor;
import com.KaufLokal.KaufLokalApplication.domain.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VotingRepository extends JpaRepository<Voting, UUID> {

}
