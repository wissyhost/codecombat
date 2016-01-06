#Makefile
#MarkDown的Make配置文件
#有一些中文无法正常显示
#sed -i '1i\<meta http-equiv="content-type" content="text/html; charset=UTF-8">' *.md

MD = markdown
MDFLAGS = -T
H2P = xhtml2pdf
H2PFLAGS = --html
SOURCES := $(wildcard *.md)
OBJECTS := $(patsubst %.md, %.html, $(wildcard *.md))
OBJECTS_PDF := $(patsubst %.md, %.pdf, $(wildcard *.md))

all: build

build: html pdf

pdf: $(OBJECTS_PDF)

html: $(OBJECTS)

$(OBJECTS_PDF): %.pdf: %.html
	    $(H2P) $(H2PFLAGS) $< > $@ 

$(OBJECTS): %.html: %.md
	    $(MD) $(MDFLAGS) -o $@ $<
clean:
	    rm -f $(OBJECTS)
