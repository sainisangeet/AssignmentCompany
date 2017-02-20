package com.example.sangeeth.assignment.recyclerviewwithprogressbar;

import java.util.List;

/**
 * Created by sangeeth on 14/2/17.
 */

public class message {


    public List<Products> getProduct() {
        return products;
    }

    public void setProduct(List<Products> product) {
        this.products = product;
    }

    private List<Products> products;

    public filters[] getFilterses() {
        return filters;
    }

    public void setFilterses(filters[] filterses) {
        this.filters = filterses;
    }

    private filters[] filters;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getImagePrefixURL() {
        return imagePrefixURL;
    }

    public void setImagePrefixURL(String imagePrefixURL) {
        this.imagePrefixURL = imagePrefixURL;
    }

    public int totalPages;
    public int totalCount;
    public String imagePrefixURL;
}
