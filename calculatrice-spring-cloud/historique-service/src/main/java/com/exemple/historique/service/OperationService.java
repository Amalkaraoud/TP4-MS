package com.exemple.historique.service;

import com.exemple.historique.model.Operation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OperationService {

    private final Map<Integer, Operation> operations = new ConcurrentHashMap<>();
    private final AtomicInteger compteur = new AtomicInteger(0);

    public Operation ajouter(Operation op) {
        op.setId(compteur.incrementAndGet());
        operations.put(op.getId(), op);
        return op;
    }

    public List<Operation> lister() {
        List<Operation> liste = new ArrayList<>(operations.values());
        liste.sort(Comparator.comparingInt(Operation::getId));
        return liste;
    }

    public Operation lire(int id) {
        return operations.get(id);
    }

    public boolean existe(int id) {
        return operations.containsKey(id);
    }

    public void remplacer(int id, Operation op) {
        op.setId(id);
        operations.put(id, op);
    }

    public Operation supprimer(int id) {
        return operations.remove(id);
    }
}