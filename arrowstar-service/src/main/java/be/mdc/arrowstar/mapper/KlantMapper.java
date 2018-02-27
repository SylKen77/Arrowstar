package be.mdc.arrowstar.mapper;

import be.mdc.arrowstar.domain.Gast;
import be.mdc.arrowstar.domain.Lid;
import be.mdc.arrowstar.domain.Persoon;
import be.mdc.arrowstar.dto.ImmutableKlantDTO;
import be.mdc.arrowstar.dto.KlantDTO;
import be.mdc.arrowstar.dto.KlantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class KlantMapper {

    @Autowired
    private AankoopMapper aankoopMapper;

    public KlantDTO lidToKlantDto(Lid lid) {
        return persoonToKlantDto(lid, KlantType.LID);
    }

    public KlantDTO gastToKlantDto(Gast gast) {
        return persoonToKlantDto(gast, KlantType.GAST);
    }

    private KlantDTO persoonToKlantDto(Persoon persoon, KlantType klantType) {
        return ImmutableKlantDTO.builder()
                .persoonId(persoon.getId())
                .type(klantType)
                .naam(persoon.getVoornaam() + " " + persoon.getNaam())
                .addAllAankopen(persoon.getOnbetaaldeAankopen().stream().map(aankoopMapper::toAankoopDto).collect(Collectors.toList()))
                .saldo(persoon.getOnbetaaldeAankopen().stream().mapToDouble(aankoop -> aankoop.getPrijs()).sum())
                .build();

    }

    public KlantDTO persoonToKlantDto(Persoon persoon) {
        if (persoon instanceof Lid) return persoonToKlantDto(persoon, KlantType.LID);
        return persoonToKlantDto(persoon, KlantType.GAST);
    }

}
