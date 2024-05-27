package edu.depaul.ticketselling.band;
import edu.depaul.ticketselling.band.BandMember;
import edu.depaul.ticketselling.band.BandMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandMemberService {

    @Autowired
    private BandMemberRepository bandMemberRepository;

    public List<BandMember> saveAll(List<BandMember> bandMembers) {
        return bandMemberRepository.saveAll(bandMembers);
    }

    public BandMember findById(Long id) {
        return bandMemberRepository.findById(id).orElse(null);
    }

    public List<BandMember> findAll() {
        return bandMemberRepository.findAll();
    }
}
