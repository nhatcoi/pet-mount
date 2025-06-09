package vn.pet.dto.response;

import lombok.*;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class Pagination {
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private long totalItems;
    private boolean isFirstPage;
    private boolean isLastPage;
    private int numberOfElements;
    private boolean hasNextPage;
    private boolean hasPreviousPage;

    public <T> Pagination(Page<T> page) {
        this.setCurrentPage(page.getNumber());
        this.setTotalPage(page.getTotalPages());
        this.setPageSize(page.getSize());
        this.setTotalItems(page.getTotalElements());
        this.setFirstPage(page.isFirst());
        this.setLastPage(page.isLast());
        this.setNumberOfElements(page.getNumberOfElements());
        this.setHasNextPage(page.hasNext());
        this.setHasPreviousPage(page.hasPrevious());
    }
}
