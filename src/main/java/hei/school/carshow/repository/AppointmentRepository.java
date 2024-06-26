package hei.school.carshow.repository;

import hei.school.carshow.db.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AppointmentRepository extends JpaRepository<Appointment, String> {
}
