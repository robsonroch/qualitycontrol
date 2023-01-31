package br.com.robson.qualitycontrol.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name= "FILE_PAHT_EVIDENCE")
@NoArgsConstructor
@AllArgsConstructor
public class FilePathEvidence {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	@Column(name = "ID")
	private Long id;
	
	@Lob
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToOne
	@JoinColumn(name= "NOTICEID")
	private Notice notice;
	
	@NotEmpty
	@Column(name = "PATH_PHYSICAL_FILE")
	private String pathPhysicalFile;
	
	@CreatedDate
	private Date createdAt;
	

}
