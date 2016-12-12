package org.wcd.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcd.Repository.TrashPointRepository;
import org.wcd.model.TrashPoint;
import org.wcd.model.TrashPointNotFoundException;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class TrashPointService {

    private final TrashPointRepository trashPointRepository;

    @Autowired
    public TrashPointService(TrashPointRepository trashPointRepository) {

        this.trashPointRepository = trashPointRepository;
    }

    public List<TrashPoint> findAllTrashPoints() {
        return trashPointRepository.findAll();
    }

    public TrashPoint findTrashPointById(BigInteger id) {
        Optional<TrashPoint> country = Optional.ofNullable(trashPointRepository.findOne(id));
        if (!country.isPresent()) {
            throw new TrashPointNotFoundException(String.format("TrashPoint %s does not exist.", id));
        }
        return country.get();
    }

    public TrashPoint saveTrashPoint(TrashPoint trashPoint) {
        return trashPointRepository.save(trashPoint);
    }
}
