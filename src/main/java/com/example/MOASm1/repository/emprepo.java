package com.example.MOASm1.repository;

import com.example.MOASm1.entity.empclass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface emprepo extends JpaRepository<empclass, Integer> {
}
