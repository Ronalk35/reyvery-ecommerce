package com.reyvery.ecommerce.reportes;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.reyvery.ecommerce.model.Producto;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ProductoExporterPDF {

	private List<Producto> listaProductos;

	public ProductoExporterPDF(List<Producto> listaProductos) {
		super();
		this.listaProductos = listaProductos;
	}

	private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();
		celda.setBackgroundColor(Color.green);
		celda.setPadding(5);

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.WHITE);

		celda.setPhrase(new Phrase("ID", fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("NOMBRE", fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("DESCRIPCIÓN DEL PRODUCTO", fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("STOCK", fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("PRECIO", fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);

	}

	private void escribirDatosDeLaTabla(PdfPTable tabla) {
		for (Producto producto : listaProductos) {
			tabla.addCell(String.valueOf(producto.getId()));
			tabla.addCell(producto.getNombre());
			tabla.addCell(producto.getDescripcion());
			tabla.addCell(String.valueOf(producto.getCantidad() + " UNID."));
			tabla.addCell(String.valueOf("S/. " + producto.getPrecio()));

		}

	}

	public void exportar(HttpServletResponse response) throws DocumentException, IOException {
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, response.getOutputStream());

		documento.open();

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fuente.setColor(Color.BLACK);
		fuente.setSize(18);

		Paragraph titulo = new Paragraph("LISTA DE PRODUCTOS REYVERY MARKET", fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);

		PdfPTable tabla = new PdfPTable(5);
		tabla.setWidthPercentage(100);
		tabla.setSpacingBefore(15);
		tabla.setWidths(new float[] { 1f, 3f, 6f, 2f, 2f });
		tabla.setWidthPercentage(110);

		escribirCabeceraDeLaTabla(tabla);
		escribirDatosDeLaTabla(tabla);

		documento.add(tabla);

		documento.add(new Paragraph("\n"));

		Paragraph mensajeFinal = new Paragraph("*Estos son todos los productos que se tienen a la fecha.");
		mensajeFinal.setAlignment(Element.ALIGN_CENTER);
		documento.add(mensajeFinal);

		try {
			ClassPathResource resource = new ClassPathResource("static/img/logo julio.png");
			Image logo = Image.getInstance(resource.getURL());

			float width = 200f;
			float height = 100f;

			logo.scaleToFit(width, height);

			logo.setAlignment(Element.ALIGN_CENTER);

			documento.add(logo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			documento.close();
		}
	}
}
