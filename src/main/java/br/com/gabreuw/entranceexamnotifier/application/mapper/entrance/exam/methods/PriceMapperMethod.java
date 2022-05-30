package br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam.methods;

import br.com.gabreuw.entranceexamnotifier.application.mapper.ToApp;
import br.com.gabreuw.entranceexamnotifier.application.mapper.ToDomain;
import br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam.annotations.PriceMapper;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.value.objects.Price;
import org.springframework.stereotype.Component;

@PriceMapper
@Component
public class PriceMapperMethod {

    @ToApp
    public Double mapToApp(Price price) {
        return price.value();
    }

    @ToDomain
    public Price mapToDomain(Double price) {
        return new Price(price);
    }

}
