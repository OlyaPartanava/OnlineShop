package by.itstep.clothesshop.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    private Integer productId;

    @Column(name = "mark")
    private Integer mark;

    @Column(name = "content")
    private String content;
}
