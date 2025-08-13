package com.Job.Job.Application.Portal.repo;

import com.Job.Job.Application.Portal.model.jobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface jobRepo extends JpaRepository<jobPost,Integer>
{
  List<jobPost> findByPostProfileContainingOrPostDescContaining(String postProfile,String postDesc );
}
