package org.leberrigaud.maven.plugins.archive

import org.apache.maven.plugin.MojoExecutionException
import org.apache.maven.project.MavenProject
import org.codehaus.gmaven.mojo.GroovyMojo

abstract class PackageMojo extends GroovyMojo
{
    /**
     * The Maven Project
     * @parameter expression = "${project}"
     * @required
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
        final def type = algorithm()
        final def destFile = "${project.build.directory}/${project.build.finalName}.${type}"
        if (type == 'zip')
        {
            ant.zip(basedir: archiveDirectory, destfile: destFile)
        }
        else
        {
            throw new MojoExecutionException("Unrecognised type $type")
        }
        project.artifact.file = new File(destFile)
    }

    abstract String algorithm()
}