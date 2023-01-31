package br.com.robson.qualitycontrol.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.robson.qualitycontrol.models.Allocation;
import br.com.robson.qualitycontrol.models.AllocationGeneric;
import br.com.robson.qualitycontrol.models.AllocationPK;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, AllocationPK> {

	public Allocation findByIdEmployeeCpf(String cpf);

	public List<Allocation> findByIdEmployeeCpfAndIdSectorId(String cpf, Long setorId);

	public Allocation findByIdEmployeeCpfAndIdSectorIdAndEndAllocationDate(String cpf, Long sectorId, Date endAllocationDate);

	@Query(nativeQuery = true, value = "SELECT A.TYPE_ALLOCATION AS typeAllocation, A.START_ALLOCATION_DATE AS startAllocationDate, "
			+ "E.COMPLETE_NAME AS employeeName, E.CPF AS cpf, E.EMAIL AS email, " + "S.NAME AS sectorName "
			+ "FROM SECTOR_EMPLOYEE A " + "LEFT JOIN EMPLOYEE E " + "ON A.EMPLOYEE_ID = E.ID "
			+ "LEFT JOIN SECTOR S " + "ON A.SECTOR_ID = S.ID " + "WHERE END_ALLOCATION_DATE = '3000-01-01 00:00:00	'")
	public List<AllocationGeneric> findAllType();

	@Query(nativeQuery = true, value = "SELECT A.TYPE_ALLOCATION AS typeAllocation, A.START_ALLOCATION_DATE AS startAllocationDate, "
			+ "E.COMPLETE_NAME AS employeeName, E.CPF AS cpf, E.EMAIL AS email, " + "S.NAME AS sectorName "
			+ "FROM SECTOR_EMPLOYEE A " + "LEFT JOIN EMPLOYEE E " + "ON A.EMPLOYEE_ID = E.ID "
			+ "LEFT JOIN SECTOR S " + "ON A.SECTOR_ID = S.ID " + "WHERE END_ALLOCATION_DATE = '3000-01-01 00:00:00	'",
			countQuery = "SELECT count(*) FROM SECTOR_EMPLOYEE")
	public Page<AllocationGeneric> findAllType(Pageable pageable);
}
