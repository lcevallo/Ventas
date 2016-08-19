/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphacell.controller;

import com.alphacell.model.Cadena;
import com.alphacell.repository.ConfigRepository;
import com.alphacell.util.jsf.FacesUtil;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.primefaces.event.FileUploadEvent;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author luis
 */
@Named
@ViewScoped
public class CargarDatosBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<Cadena> cmbCadenas;
    private Cadena selectedCadena;
    private Date fechaInventario;
    private Date fechaVenta;


    @Inject
    private ConfigRepository configRepository;

    @PostConstruct
    public void init()
    {

        this.cmbCadenas=this.configRepository.findAll();

    }


    public void handleFileUpload(FileUploadEvent event) {

        if (event.getFile().equals(null)) {

            FacesUtil.addInfoMessage("El archivo es null");

        }
        InputStream file;
        HSSFWorkbook workbook = null;
        try {
            file = event.getFile().getInputstream();
            workbook = new HSSFWorkbook(file);
        } catch (IOException e) {

            FacesUtil.addErrorMessage("Error Leyendo archivo : " + e);

        }

        HSSFSheet sheet = workbook.getSheetAt(1);

        Iterator<Row> rowIterator = sheet.iterator();
        Calendar calendar = new GregorianCalendar();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            //Job job = new Job();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:

                        if (HSSFDateUtil.isCellDateFormatted(cell) || HSSFDateUtil.isCellInternalDateFormatted(cell)) {
                            calendar.setTime(cell.getDateCellValue());
                        } else {
                            System.out.print(cell.getNumericCellValue() + "\t\t");
                        }
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "\t\t");
                        break;
                }

            }
        }
    }


    public List<Cadena> getCmbCadenas() {
        return cmbCadenas;
    }

    public void setCmbCadenas(List<Cadena> cmbCadenas) {
        this.cmbCadenas = cmbCadenas;
    }

    public Cadena getSelectedCadena() {
        return selectedCadena;
    }

    public void setSelectedCadena(Cadena selectedCadena) {
        this.selectedCadena = selectedCadena;
    }

    public Date getFechaInventario() {
        return fechaInventario;
    }

    public void setFechaInventario(Date fechaInventario) {
        this.fechaInventario = fechaInventario;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
}
