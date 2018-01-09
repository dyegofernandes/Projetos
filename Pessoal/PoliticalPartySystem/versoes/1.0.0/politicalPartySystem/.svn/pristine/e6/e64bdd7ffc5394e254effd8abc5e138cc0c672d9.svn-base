/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.politicalpartysystem.modelo.enums;

/**
 *
 * @author Juniel
 */
public enum TypeMessageBoard {

    PDF(0, "Portable Document Format", ".PDF"),
    DOC(1, "Documento do Microsoft Office Word 97-2003", ".DOC"),
    DOCX(2, "Documento do Microsoft Office Word", ".DOCX"),
    TXT(3, "Common name for ASCII text file", ".TXT"),
    PNG(4, "Portable Network Graphics", ".PNG"),
    JPG(5, "Graphics file JPEG Joint Photography Experts Group format", ".JPG"),
    JPEG(6, "Graphics file JPEG Joint Photography Experts Group format", ".JPEG"),
    XLS(7, "Planilha do Microsoft Office Excel 97-2003", ".XLS"),
    XLSX(8, "Planilha do Microsoft Office Excel", ".XLSX"),
    ZIP(9, "Arquivo Compactado", ".ZPI"),;

    private TypeMessageBoard(int code, String text, String extension) {
        this.text = text;
        this.code = code;
        this.extension = extension;
    }

    private String text;
    private int code;
    private String extension;

    public String getText() {
        return text;
    }

    public int getCode() {
        return code;
    }

    public String getExtension() {
        return extension;
    }

}
