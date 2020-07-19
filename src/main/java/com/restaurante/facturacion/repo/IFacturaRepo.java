package com.restaurante.facturacion.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restaurante.facturacion.model.Factura;

public interface IFacturaRepo extends JpaRepository<Factura, Integer> {
	
	@Modifying
	@Query(value ="SELECT f.id_factura , SUM (coalesce(df.monto)) FROM Factura f, Detalle_Factura df WHERE f.fecha BETWEEN :fecha AND :fechaLimite AND f.id_factura = df.id_factura GROUP BY f.id_factura", nativeQuery = true)
	List<Object[]> listarResumenFacturas(@Param("fecha") LocalDateTime fecha, @Param("fechaLimite") LocalDateTime fechaLimite);

}
