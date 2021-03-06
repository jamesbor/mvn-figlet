package sample.plugin;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

import com.github.lalyos.jfiglet.FigletFont;

/**
 * Goal which touches a timestamp file.
 *
 * @deprecated Don't use!
 */

@Mojo( name = "touch", defaultPhase = LifecyclePhase.PROCESS_SOURCES )
public class MvnFiglet
    extends AbstractMojo
{
    /**
     * The greeting to display.
     */
    @Parameter( property = "bannermessage", defaultValue = "Hello World!" )
    private String greeting;
    /**
     * Location of the file.
     */
    @Parameter( defaultValue = "${project.build.directory}", property = "outputDir", required = true )
    private File outputDirectory;

    public void execute()
        throws MojoExecutionException
    {
        String asciiArt = FigletFont.convertOneLine( greeting );

        Scanner scanner = new Scanner(asciiArt);
        while (scanner.hasNextLine()) {
          String line = scanner.nextLine();
          // process the line
          getLog().info( line );
        }
        scanner.close();


    }
}
