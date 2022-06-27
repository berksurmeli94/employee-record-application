package com.emrap.app.core.utilities.result;

public class FilterResult<T> {

    private T Items;
    private int TotalCount;
    private int FilteredCount;
    private int CurrentPage;
    private int PageCount;

    public T getItems() {
        return this.Items;
    }

    public void setItems(T Items) {
        this.Items = Items;
    }

    public int getTotalCount() {
        return this.TotalCount;
    }

    public void setTotalCount(int TotalCount) {
        this.TotalCount = TotalCount;
    }

    public int getFilteredCount() {
        return this.FilteredCount;
    }

    public void setFilteredCount(int FilteredCount) {
        this.FilteredCount = FilteredCount;
    }

    public int getCurrentPage() {
        return this.CurrentPage;
    }

    public void setCurrentPage(int CurrentPage) {
        this.CurrentPage = CurrentPage;
    }

    public int getPageCount() {
        return this.PageCount;
    }

    public void setPageCount(int PageCount) {
        this.PageCount = PageCount;
    }
}
