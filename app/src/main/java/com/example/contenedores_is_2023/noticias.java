package com.example.contenedores_is_2023;

public class noticias {
    private String titulo;
    private String subtitulo;
    public noticias(String tit, String
            sub){
        titulo = tit;
        subtitulo = sub;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getSubtitulo(){
        return subtitulo;
    }
}
