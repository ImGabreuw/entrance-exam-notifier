package br.com.gabreuw.entranceexamnotifier.shared.pagination;

import br.com.gabreuw.entranceexamnotifier.shared.validation.SelfValidation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public record PageInfo(
        @PositiveOrZero
        int pageNumber,

        @Positive
        int pageSize,

        int pageInterval,

        int firstElementPosition,

        int lastElementPosition
) implements SelfValidation<PageInfo> {

    public PageInfo(int pageNumber, int pageSize, int pageInterval, int firstElementPosition, int lastElementPosition) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.pageInterval = pageInterval;
        this.firstElementPosition = firstElementPosition;
        this.lastElementPosition = lastElementPosition;

        validate(this);
    }

    public static PageInfo create(int pageNumber, int pageSize) {
        int pageInterval = pageSize - 1;
        int lastElementPosition = (pageNumber + 1) * pageInterval + (pageNumber + 1);
        int firstElementPosition = lastElementPosition - pageInterval;

        return new PageInfo(pageNumber, pageSize, pageInterval, firstElementPosition, lastElementPosition);
    }

    public static PageInfo createDefault() {
        return create(0, 20);
    }

    public PageRequest toPageRequest() {
        return PageRequest.of(pageNumber, pageSize);
    }

    public PageRequest toSortedPageRequest() {
        return toPageRequest()
                .withSort(
                        Sort.by("collegeName").ascending()
                );
    }

}
