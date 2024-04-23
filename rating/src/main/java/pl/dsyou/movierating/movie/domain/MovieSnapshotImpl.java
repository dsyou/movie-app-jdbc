package pl.dsyou.movierating.movie.domain;

import java.time.LocalDate;

class MovieSnapshotImpl implements MovieSnapshot {

    private final Movie movie;
    private final Description description;

    public MovieSnapshotImpl(Movie movie) {
        this.movie = movie;
        this.description = movie.getDescription();
    }

    @Override
    public long getId() {
        return this.movie.getId();
    }

    @Override
    public String getUuid() {
        return this.movie.getUuid();
    }

    @Override
    public String getTitle() {
        return this.description.getTitle();
    }

    @Override
    public String getGenre() {
        return this.description.getGenre();
    }

    @Override
    public LocalDate getProductionDate() {
        return this.description.getProductionDate();
    }

}

