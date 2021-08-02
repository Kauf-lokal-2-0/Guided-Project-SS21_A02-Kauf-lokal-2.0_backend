package com.KaufLokal.KaufLokalApplication.domain.repository;


import com.KaufLokal.KaufLokalApplication.domain.model.PollOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PollOptionRepository extends JpaRepository<PollOption, UUID> {

}
