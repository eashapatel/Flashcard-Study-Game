package cs3500.pa01;

/**
 * Interface for importing study sets
 */
public interface StudySetImporter {

  /**
   * imports a study set
   *
   * @return the study set
   */
  public StudySet importStudySet(int numCards, boolean random);

}
