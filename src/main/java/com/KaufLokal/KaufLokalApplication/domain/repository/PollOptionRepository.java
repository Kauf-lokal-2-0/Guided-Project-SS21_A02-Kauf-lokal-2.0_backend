package com.KaufLokal.KaufLokalApplication.domain.repository;


import com.KaufLokal.KaufLokalApplication.domain.model.PollOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PollOptionRepository extends JpaRepository<PollOption, UUID> {


}
