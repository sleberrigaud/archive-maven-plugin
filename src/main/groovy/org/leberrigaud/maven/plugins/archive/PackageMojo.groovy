package org.leberrigaud.maven.plugins.archive

import org.apache.maven.project.MavenProject
import org.codehaus.gmaven.mojo.GroovyMojo

abstract class PackageMojo extends GroovyMojo
{
    /**
     * The Maven Project
     * @parameter expression = "${project}"
     * @required true
     * @readonly
     */
    private MavenProject project;

    /**
     * The directory to archive
     * @parameter expression = "${archive.directory}" default-value = "${project.build.outputDirectory}"
     * @required
     */
    private String archiveDirectory;

    void execute()
    {
        if (algorithm() == 'zip')
        {
            ant.zip(basedir: archiveDirectory, destfile: project.build.finalName)
        }
    }

    abstract String algorithm()
}