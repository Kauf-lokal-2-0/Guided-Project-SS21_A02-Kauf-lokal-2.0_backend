package com.KaufLokal.KaufLokalApplication.domain.repository;


import com.KaufLokal.KaufLokalApplication.domain.model.VotingOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VotingOptionRepository extends JpaRepository<VotingOption, UUID> {


}
