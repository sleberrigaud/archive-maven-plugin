package org.leberrigaud.maven.plugins.archive

/**
 * @goal zip
 */
class ZipMojo extends PackageMojo
{
    String algorithm()
    {
        return 'zip'
    }
}
