package br.com.robson.qualitycontrol.models;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name= "FILE_PAHT_EVIDENCE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilePathEvidence implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	@Column(name = "ID")
	private Long id;
		
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name= "NOTICEID")
	private Notice notice;
	
	@NotEmpty
	@Column(name = "PATH_PHYSICAL_FILE")
	private String pathPhysicalFile;
	
	@CreatedDate
	private Date createdAt;
	

}
