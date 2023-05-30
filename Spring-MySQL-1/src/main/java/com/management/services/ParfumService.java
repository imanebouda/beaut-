package com.management.services;

import com.management.entities.Parfum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParfumService {
    Parfum saveParfum(Parfum parfum);
    Parfum updateParfum(Parfum parfum);
    Parfum getParfum(Long id);
    List<Parfum> getAllParfums();
    void deleteParfumById(Long id);
    void deleteAllParfums();
}
