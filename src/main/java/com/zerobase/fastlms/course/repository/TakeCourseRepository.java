package com.zerobase.fastlms.course.repository;

import com.zerobase.fastlms.course.entity.TakeCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TakeCourseRepository extends JpaRepository<TakeCourse, Long> {

    long countByCourseIdAndUserIdAndStatusIn(long courseId, String userId, Collection<String> statusList);
    
}
