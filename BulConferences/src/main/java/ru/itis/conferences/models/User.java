package ru.itis.conferences.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;


/**
 * Just a registered user
 * @author Bulat Bilalov
 * @version 1.0
 * @see ru.itis.conferences.models.BaseEntity
 * @see db.changelog/db.changelog-1.0.xml
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "roles")
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity implements Comparable<User>{

    /**
     * User display name
     */
    @Column(name = "nickname")
    private String nickname;

    /**
     * Contact information (mail)
     */
    @Column(name = "email")
    private String email;

    /**
     * Hashed user password
     */
    @Column(name = "password")
    private String password;

    /**
     * Unique key to verify your account
     */
    @Column(name = "token", length = 500)
    private String token;

    /**
     * Role having users
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    /**
     * Feedback left to the site
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_feedbacks",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "feedback_id", referencedColumnName = "id")})
    private List<Feedback> feedbacks;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Set<Conference> conferences;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Report> reports;

    /**
     * Constructor for testing spring security
     *
     * @param email    The mail that the user specified during registration
     * @param password Hashed password specified during registration
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(User o) {
        return email.compareTo(o.getEmail());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
