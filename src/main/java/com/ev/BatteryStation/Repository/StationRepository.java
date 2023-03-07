package com.ev.BatteryStation.Repository;

import com.ev.BatteryStation.Entity.StationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface StationRepository extends JpaRepository<StationEntity,Long> {
}
