package br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam.methods;

import br.com.gabreuw.entranceexamnotifier.application.mapper.ToApp;
import br.com.gabreuw.entranceexamnotifier.application.mapper.ToDomain;
import br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam.annotations.WebsiteMapper;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.value.objects.Website;
import org.springframework.stereotype.Component;

@WebsiteMapper
@Component
public class WebsiteMapperMethod {

    @ToApp
    public String mapToApp(Website website) {
        return website.url();
    }

    @ToDomain
    public Website mapToDomain(String website) {
        return new Website(website);
    }

}
