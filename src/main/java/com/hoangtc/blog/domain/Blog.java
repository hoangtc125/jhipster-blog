package com.hoangtc.blog.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Blog.
 */
@Entity
@Table(name = "blog")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "blog")
    @JsonIgnoreProperties(value = { "applicationUser", "blog" }, allowSetters = true)
    private Set<Reaction> reactions = new HashSet<>();

    @OneToMany(mappedBy = "blog")
    @JsonIgnoreProperties(value = { "applicationUser", "blog" }, allowSetters = true)
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "internalUser", "blogs", "reactions", "comments", "products" }, allowSetters = true)
    private ApplicationUser applicationUser;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Blog id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public Blog title(String title) {
        this.setTitle(title);
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public Blog description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return this.content;
    }

    public Blog content(String content) {
        this.setContent(content);
        return this;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Reaction> getReactions() {
        return this.reactions;
    }

    public void setReactions(Set<Reaction> reactions) {
        if (this.reactions != null) {
            this.reactions.forEach(i -> i.setBlog(null));
        }
        if (reactions != null) {
            reactions.forEach(i -> i.setBlog(this));
        }
        this.reactions = reactions;
    }

    public Blog reactions(Set<Reaction> reactions) {
        this.setReactions(reactions);
        return this;
    }

    public Blog addReaction(Reaction reaction) {
        this.reactions.add(reaction);
        reaction.setBlog(this);
        return this;
    }

    public Blog removeReaction(Reaction reaction) {
        this.reactions.remove(reaction);
        reaction.setBlog(null);
        return this;
    }

    public Set<Comment> getComments() {
        return this.comments;
    }

    public void setComments(Set<Comment> comments) {
        if (this.comments != null) {
            this.comments.forEach(i -> i.setBlog(null));
        }
        if (comments != null) {
            comments.forEach(i -> i.setBlog(this));
        }
        this.comments = comments;
    }

    public Blog comments(Set<Comment> comments) {
        this.setComments(comments);
        return this;
    }

    public Blog addComment(Comment comment) {
        this.comments.add(comment);
        comment.setBlog(this);
        return this;
    }

    public Blog removeComment(Comment comment) {
        this.comments.remove(comment);
        comment.setBlog(null);
        return this;
    }

    public ApplicationUser getApplicationUser() {
        return this.applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public Blog applicationUser(ApplicationUser applicationUser) {
        this.setApplicationUser(applicationUser);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Blog)) {
            return false;
        }
        return id != null && id.equals(((Blog) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Blog{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", content='" + getContent() + "'" +
            "}";
    }
}
