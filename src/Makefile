# Find .java files
SRC = $(wildcard *.java)

# Define .SUFFIXES for Java extensions
.SUFFIXES: .java .class

# Implement ".java -> .class" conversion
.java.class:
	@javac $<

# Create Java .class files
all: $(SRC:.java=.class)

run: all
	java Main


# Remove generated files
clean:
	@rm *.class