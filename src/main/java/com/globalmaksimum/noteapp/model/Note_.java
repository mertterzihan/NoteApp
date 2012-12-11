package com.globalmaksimum.noteapp.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-11-29T15:20:47.398+0200")
@StaticMetamodel(Note.class)
public class Note_ {
	public static volatile SingularAttribute<Note, Integer> id;
	public static volatile SingularAttribute<Note, String> note;
	public static volatile SingularAttribute<Note, Date> date;
	public static volatile SingularAttribute<Note, String> priority;
	public static volatile SingularAttribute<Note, String> username;
}
