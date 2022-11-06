package com.hoangtc.blog.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hoangtc.blog.domain.enumeration.Emotion;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Reaction.
 */
@Entity
@Table(name = "reaction")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Reaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "emotion")
    private Emotion emotion;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "internalUser", "blogs", "reactions", "comments", "products" }, allowSetters = true)
    private ApplicationUser applicationUser;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "reactions", "comments", "applicationUser" }, allowSetters = true)
    private Blog blog;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Reaction id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Emotion getEmotion() {
        return this.emotion;
    }

    public Reaction emotion(Emotion emotion) {
        this.setEmotion(emotion);
        return this;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public ApplicationUser getApplicationUser() {
        return this.applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public Reaction applicationUser(ApplicationUser applicationUser) {
        this.setApplicationUser(applicationUser);
        return this;
    }

    public Blog getBlog() {
        return this.blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Reaction blog(Blog blog) {
        this.setBlog(blog);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Reaction)) {
            return false;
        }
        return id != null && id.equals(((Reaction) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Reaction{" +
            "id=" + getId() +
            ", emotion='" + getEmotion() + "'" +
            "}";
    }
}
