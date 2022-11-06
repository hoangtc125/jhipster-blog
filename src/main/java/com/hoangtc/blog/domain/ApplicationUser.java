package com.hoangtc.blog.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A ApplicationUser.
 */
@Entity
@Table(name = "application_user")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ApplicationUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private User internalUser;

    @OneToMany(mappedBy = "applicationUser")
    @JsonIgnoreProperties(value = { "reactions", "comments", "applicationUser" }, allowSetters = true)
    private Set<Blog> blogs = new HashSet<>();

    @OneToMany(mappedBy = "applicationUser")
    @JsonIgnoreProperties(value = { "applicationUser", "blog" }, allowSetters = true)
    private Set<Reaction> reactions = new HashSet<>();

    @OneToMany(mappedBy = "applicationUser")
    @JsonIgnoreProperties(value = { "applicationUser", "blog" }, allowSetters = true)
    private Set<Comment> comments = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ApplicationUser id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getInternalUser() {
        return this.internalUser;
    }

    public void setInternalUser(User user) {
        this.internalUser = user;
    }

    public ApplicationUser internalUser(User user) {
        this.setInternalUser(user);
        return this;
    }

    public Set<Blog> getBlogs() {
        return this.blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        if (this.blogs != null) {
            this.blogs.forEach(i -> i.setApplicationUser(null));
        }
        if (blogs != null) {
            blogs.forEach(i -> i.setApplicationUser(this));
        }
        this.blogs = blogs;
    }

    public ApplicationUser blogs(Set<Blog> blogs) {
        this.setBlogs(blogs);
        return this;
    }

    public ApplicationUser addBlog(Blog blog) {
        this.blogs.add(blog);
        blog.setApplicationUser(this);
        return this;
    }

    public ApplicationUser removeBlog(Blog blog) {
        this.blogs.remove(blog);
        blog.setApplicationUser(null);
        return this;
    }

    public Set<Reaction> getReactions() {
        return this.reactions;
    }

    public void setReactions(Set<Reaction> reactions) {
        if (this.reactions != null) {
            this.reactions.forEach(i -> i.setApplicationUser(null));
        }
        if (reactions != null) {
            reactions.forEach(i -> i.setApplicationUser(this));
        }
        this.reactions = reactions;
    }

    public ApplicationUser reactions(Set<Reaction> reactions) {
        this.setReactions(reactions);
        return this;
    }

    public ApplicationUser addReaction(Reaction reaction) {
        this.reactions.add(reaction);
        reaction.setApplicationUser(this);
        return this;
    }

    public ApplicationUser removeReaction(Reaction reaction) {
        this.reactions.remove(reaction);
        reaction.setApplicationUser(null);
        return this;
    }

    public Set<Comment> getComments() {
        return this.comments;
    }

    public void setComments(Set<Comment> comments) {
        if (this.comments != null) {
            this.comments.forEach(i -> i.setApplicationUser(null));
        }
        if (comments != null) {
            comments.forEach(i -> i.setApplicationUser(this));
        }
        this.comments = comments;
    }

    public ApplicationUser comments(Set<Comment> comments) {
        this.setComments(comments);
        return this;
    }

    public ApplicationUser addComment(Comment comment) {
        this.comments.add(comment);
        comment.setApplicationUser(this);
        return this;
    }

    public ApplicationUser removeComment(Comment comment) {
        this.comments.remove(comment);
        comment.setApplicationUser(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApplicationUser)) {
            return false;
        }
        return id != null && id.equals(((ApplicationUser) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ApplicationUser{" +
            "id=" + getId() +
            "}";
    }
}
